## PCM - Project Cost Management

**Table Names - Use MySql**
1. Project: Represents a specific project being managed.<br>
	```Attributes: Id, ProjectName, ProjectDescription, StartDate, EndDate,Status```
2. CostCategory: Represents different categories or types of project costs.<br>
	```Attributes: Id, CategoryName, CategoryDescription```
3. CostItem: Represents individual cost items or expenses associated with the project.<br>```Attributes: Id, ItemName, ItemDescription, Amount,CostCategoryId, ProjectId,
	Date,EntryBy,ApprovedBy,Status```
4. Member: Represents the members involved in the project.<br>```Attributes: Id,Email, Password, MemberName, Role, Department,Status```

- Create CRUD - API Endpoint for each Tables.
- Make Report API for a Project cost with date range filter

## How to use 🤔

(1) Register a new member ```api/v1/auth/register```<br>
    After registration you will get a access token.

(2) If you are already registered, then you can login here ```api/v1/auth/login```<br>
    After login  you will get a access token


(3) Set the access token in root Authorization (Type : Bearer Token)

(4) Now you have access to Project, Cost Category, Cost Item & Member

(2) you can logout here ```api/v1/auth/logout```<br>
    After logout your access token is not valid anymore.

(5) "Report API for a Project cost with date range filter" feature will be added soon.


👉 [You can decode your access token here](https://jwt.io/).
