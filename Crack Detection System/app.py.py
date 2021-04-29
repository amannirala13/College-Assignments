import serial
import matplotlib as mpt
import numpy as np
try:
    import tkinter as tk
except:
    import Tkinter as tk
import time
import threading
from datetime import datetime, timedelta


class App(tk.Frame):
    
    def __init__(self,root, *args, **kwargs):
        tk.Frame.__init__(self,root, *args, **kwargs)
        self.root = root
        
        self.mainCalibration = self.Calibrate()
        self.IS_DETECTION_ON = False
        
        tk.Label(self.root, text="Depth Sensitivity(cm): ").grid(row=0)
        tk.Label(self.root, text="Max Distance Allowed(cm): ").grid(row=1)
        tk.Label(self.root, text="Calibration Time(s): ").grid(row=3)
        self.depthTextField = tk.Entry(self.root)
        self.maxDistanceField = tk.Entry(self.root)
        self.calibrationTimeTextField = tk.Entry(self.root)
        self.calibrateBtn = tk.Button(self.root, text="Calibrate",width = 25)
        self.startBtn = tk.Button(self.root, text="Start detection", width = 25)
        
        self.depthTextField.grid(row=0, column=1)
        self.maxDistanceField.grid(row=1, column=1)
        self.calibrationTimeTextField.grid(row=3, column=1)
        self.calibrateBtn.grid(row=4)
        self.startBtn.grid(row=4, column=1)
        
        self.calibrateBtn.config(command=lambda:threading.Thread(target=self.startCalibration).start())
        self.startBtn.config(command=lambda:threading.Thread(target=self.startDetection, daemon=True).start())
    
    
    
    class Calibrate():
        def __init__(self):
            self.surface_normal = 0.0
            self.max_error = 0.0
            self.min_error = 0.0
            self.mean_error = 0.0
            self.max_distance = 0.0
            self.surface_max_distance = 0.0
            self.surface_min_distance = 0.0
            self.is_calibrated = False



    def startSerialPortCom(self):
        print("STATUS: Starting communication with serial port...")
        self.serialPort = serial.Serial(port="COM10", baudrate=9600, bytesize=8, timeout=2, stopbits=serial.STOPBITS_ONE)
            
            
    def stopSerialPortCom(self):
        print("STATUS: Stopping communication with serial port...")
        try:
            self.serialPort.close()
        except Exception:
            print("ERROR: Unable to close serial port")
            
            

    def startCalibration(self):
        try:
            self.startSerialPortCom()
        except:
            print("ERROR: Unable to open serial port")
            return
        #TODO: Put this whole block in try and catch and make changes in status text
        self.calibrateBtn.config(text= "Calibrating...")
        self.calibrateBtn.config(state = 'disable')
        self.startBtn.config(state = 'disable')
        try:
            self.mainCalibration.max_distance = float(self.maxDistanceField.get())
            calibrationTime = float(self.calibrationTimeTextField.get())
        except:
            print("Please enter valid number arguments")
            
        endTime = datetime.now() + timedelta(seconds=calibrationTime)
        distanceList = []
        print("STATUS: Reading input....please wait...")
        while(datetime.now()<endTime):
            serialString = ''
            try:
                if(self.serialPort.in_waiting > 0):
                    serialString = self.serialPort.readline()
                    distance = float(serialString.decode('ascii').strip())
                    distanceList.append(distance)
            except Exception:
                print("WARNING: Skipped corrupted bytes!")
                        
        data = np.array(distanceList)
        
        self.mainCalibration.surface_normal = np.mean(data)
        self.mainCalibration.surface_min_distance = np.min(data)
        self.mainCalibration.surface_max_distance = np.max(data)
        self.mainCalibration.max_error = self.mainCalibration.surface_max_distance - self.mainCalibration.surface_normal
        self.mainCalibration.min_error = self.mainCalibration.surface_min_distance - self.mainCalibration.surface_normal
        self.mainCalibration.mean_error = np.mean(data - self.mainCalibration.surface_normal)
        self.mainCalibration.is_calibrated = True
        
        print("Normal surface reading = ", self.mainCalibration.surface_normal)
        print("Minimum surface reading: ", self.mainCalibration.surface_min_distance)
        print("Maximum surface reading = ", self.mainCalibration.surface_max_distance)
        print("Maximum error = ", self.mainCalibration.max_error)
        print("Minimum error = ", self.mainCalibration.min_error)
        print("Mean error = ", self.mainCalibration.mean_error)
        
        if self.mainCalibration.max_distance < self.mainCalibration.surface_max_distance:
            self.mainCalibration.is_calibrated = False
            print("ERROR: Calibration failed due to noisy readings. Please calibrate again before using the application.")
            self.calibrateBtn.config(text = "Calibrate Now!")
            self.calibrateBtn.config(state = 'normal')
            self.startBtn.config(state = 'normal')
        else:
            self.calibrateBtn.config(text = "Calibrate")
            self.calibrateBtn.config(state = 'normal')
            self.startBtn.config(state = 'normal')
        self.stopSerialPortCom()               

        
        
    def startDetection(self):
        if self.IS_DETECTION_ON:
            self.IS_DETECTION_ON = False
        else:
            if not self.mainCalibration.is_calibrated:
                self.stopSerialPortCom()
                threading.Thread(self.startCalibration()).start()
            print("Detecting surface...")
            try:
                self.startSerialPortCom()
            except:
                print("ERROR: Unable to open serial port")
                return
            self.IS_DETECTION_ON = True
            while(self.IS_DETECTION_ON):
                serialString = ''
                try:
                    if(self.serialPort.in_waiting > 0):
                        serialString = self.serialPort.readline()
                        distance = float(serialString.decode('ascii').strip())
                        print(distance)
                except Exception:
                    print("WARNING: Skipped corrupted bytes!")
        self.stopSerialPortCom()    



if __name__ == '__main__': 
    window = tk.Tk()
    window.title("Crack detection - v1.0")
    App(root = window)
    window.mainloop()