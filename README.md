# DemoWebPages
<br>DemoWebPages is a very simply and compact web with 3 pages, which includes Login, Register and Menu. It helps me review how to write a web and how to use HTML, which I have learned in the class. Although it is a small and incompleted web, I do consider the color and layout of it carfully. Therefore, it may be a good example to learn how to construct a web at the very beginning. I welcome everyone to downloan for playing, learning or adding something new to it. Please put a \:star: on my project. :blush:
## Table of Contents
- [Background](#background) 
- [Install](#install)
- [Usage](#usage)
## Background
### ER Model 
![image](https://github.com/LangqingZou/DemoWebPages/blob/master/ER.png)
### Description 
DemoWebPages is like a hotel web, such that a person could be a guest, an employee or a guest **and** an employee. As lons as a person register, his/her information will be shown in the `PERSON` table in database. If he/she is a guest, his/her information will be shown in the `GUEST` table in database. If he/she is an employee, his/her information will be shown in the `EMPLOYEE` table in database. Attributes of person are common infomation of person, and an employee has two more attributes. Email will be the primary key in each tables.
## Install
* Eclipse or any other JAVA IDE
* TomCat
* mySQL database
## Usage
* Install all needed tools above
* Create three tables in mySQL database, PERSON, EMPLOYEE, GUEST respectively
* Replace xxxxx with your scheme name, user name and password of database in DBConnect.java
* Run login.jsp
