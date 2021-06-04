import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from sklearn.model_selection import train_test_split as tts
from sklearn.svm import SVC
from sklearn.metrics import classification_report, confusion_matrix
from mlxtend.plotting import plot_decision_regions
from sklearn.decomposition import PCA
import matplotlib.pyplot as plt

'''
SVM Sample for training and testing model based on breast cancer data
author: Aman Kumar Nirala (github.com/amannirala13)
'''

'''
Read csv file using pandas
----------------------------
This function reads data from csv file and creates a pandas dataframe
'''


def readfile(path):
    return pd.read_csv(path)


'''
Removing unwanted columns and mapping classification classes to numbers
----------------------------
This function cleans and normalizes data
'''


def prepare_data(df):  # Taking dataframe to clean as argument
    df = df.iloc[:, :-1]  # Selecting the all the rows or all the columns excluding the last column
    df['diagnosis'] = df['diagnosis'].map({'M': 1, 'B': -1})  # Normalizing the column values to make processing faster
    return df  # Returning the new dataframe


'''
Separating features and outputs and also normalizing the features data
----------------------------
Separating the independent variables AKA features and dependent variables AKA output into two different dataframes
'''


def get_features_and_results(df):  # Taking the target dataframe as argument
    y = df.loc[:, 'diagnosis']  # Selecting all the rows in the 'diagnosis' column
    x = df.iloc[:, 2:]  # Selecting all the rows from column 2 to the last
    x = pd.DataFrame(MinMaxScaler().fit_transform(x.values))  # Scaling the values to a certain range
    return x, y  # Returning both x and y


'''
Splits data set in training and testing
-----------------------------------
This function divides the data between training and testing sets
'''


def split_training_set(x, y):  # Taking features and output sets as arguments
    return tts(x, y, test_size=0.2, random_state=42)  # Returning training and testing data


'''
Prints report of the analysis algorithm
-------------------------------------
This function print the detailed analysis of the Algorithm
'''


def algorithm_analysis(y_pred, y_actual):
    print(confusion_matrix(y_actual, y_pred))
    print(classification_report(y_actual, y_pred))


if __name__ == '__main__':
    data_raw = readfile("C:/Users/amann/Desktop/svm/data.csv")      # Reading csv data
    data = prepare_data(data_raw)       # Preparing data and cleaning
    X, Y = get_features_and_results(data)       # Separating features and outputs
    X_train, X_test, Y_train, Y_test = split_training_set(X, Y)     # Separating testing and training data

    X_train_pca = PCA(n_components=2).fit_transform(X_train)        # Performing PCA over the features and reducing
    # the dimensions to 2 for being able to plot the data
    X_test_pca = PCA(n_components=2).fit_transform(X_test)        # Performing PCA over the features and reducing
    # the dimensions to 2 for being able to plot the data

    svc_classifier = SVC(kernel='linear')       # Creating a linear support vector classifier
    svc_classifier.fit(pd.DataFrame(X_train_pca), Y_train)      # Training the model with training dataset

    ''' 
    Plotting graph
    -----------------------------
    This block plot the graph of the classifier
    '''
    plot_decision_regions(X=X_train_pca,
                          y=Y_train.values,
                          clf=svc_classifier,
                          legend=2)
    plt.show()

    '''
    Doing the predications
    -----------------------------
    This block performs classification operations using the classifier
    '''
    Y_pred = svc_classifier.predict(X_test_pca)     # Performing prediction/classification
    Y_pred = pd.DataFrame(Y_pred)       # Converting the prediction list into pandas dataframe

    algorithm_analysis(Y_pred, Y_test)      # Calling analysis function

    print(svc_classifier.score(X_train_pca, Y_train))   # Printing score
