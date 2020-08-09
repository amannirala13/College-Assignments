# -*- coding: utf-8 -*-
"""
Created on Mon Aug 10 03:04:19 2020

@author: amann
"""


import requests as req

batch = input("Enter your batch type code: ")

params = {"type":batch, "submit":"Submit"}
header = {"User-Agent":"Mozilla/5.0"}
url = "http://time-table.sdrclabs.in/day.php"

res = req.Session().post(url=url,headers=header,data=params)
body = str(res._content)
print(body)
