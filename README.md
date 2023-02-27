# BankApi

First of all, in order to use our h2 database properly, in our BankApi/src/main/resources/application.properties file
We should set spring.jpa.hibernate.ddl-auto=update to spring.jpa.hibernate.ddl-auto=create in the first place. 
so the database will create the tables once and then we can act on these created tables

After performing this operation, repeat the expression
spring.jpa.hibernate.ddl-auto=update
we should change it to


now we can start our project.
When we log in to the http://localhost:8080/h2-console/ url address, we can see the previously created tables and the values that exist in these tables.

![image](https://user-images.githubusercontent.com/90156001/221477685-69a8413f-7159-4b0d-ac70-9824ce0d4de2.png)

![image](https://user-images.githubusercontent.com/90156001/221477767-0317546f-e34b-46f3-a5cc-df380a12de8a.png)

![image](https://user-images.githubusercontent.com/90156001/221477788-05ee02fb-5d51-49e2-8840-b814d3c2230b.png)

![image](https://user-images.githubusercontent.com/90156001/221477813-e3113783-578c-418f-8ec6-a5bd5f14245d.png)

![image](https://user-images.githubusercontent.com/90156001/221477836-b225380c-1741-4a0a-9cd8-1789e24024f5.png)

If we want to add customers, we need to use a post method as I have shown in the image.
![image](https://user-images.githubusercontent.com/90156001/221478570-225d8a97-3e05-4253-9db5-97ec22f4de9b.png)

The result of this method returns us.                                                    

![image](https://user-images.githubusercontent.com/90156001/221478638-55304921-bcad-4035-905a-dfc8f75c7194.png)

and when we examine the customer table in our h2 database, we see that our data has been added.
![image](https://user-images.githubusercontent.com/90156001/221478756-1159aafa-9f49-49ce-80c8-5340c67c7741.png)

the same operations are as follows for update delete
![image](https://user-images.githubusercontent.com/90156001/221478960-fe3d18a6-ac4e-41ea-ba2b-a6878ea853a6.png)
![image](https://user-images.githubusercontent.com/90156001/221478986-91fc7bcf-2b65-4109-8dbd-9d4dd3a65f83.png)

![image](https://user-images.githubusercontent.com/90156001/221479101-925184e1-cb26-4672-b678-464f7a5e88b7.png)
![image](https://user-images.githubusercontent.com/90156001/221479123-95bf50a9-3567-48f2-9659-d100222d98cc.png)

Here are the steps to apply for a loan:

![image](https://user-images.githubusercontent.com/90156001/221479378-f16a18e8-db8b-4def-9213-246045f3e2c6.png)

The credit request information created by this method is listed under the credit table.
![image](https://user-images.githubusercontent.com/90156001/221479519-17188d55-db7a-4a19-8dac-ddb722c7da31.png)

In order to list the results of the existing applications, we should follow the path in the example below.
![image](https://user-images.githubusercontent.com/90156001/221479665-47a21b70-a2b9-4535-8af7-e44fb121c961.png)



