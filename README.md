## PCM - Project Cost Management

Table Names - Use MySql
Project: Represents a specific project being managed.
● Attributes: Id, ProjectName, ProjectDescription, StartDate, EndDate,Ststus
CostCategory: Represents different categories or types of project costs.
● Attributes: Id, CategoryName, CategoryDescription
CostItem: Represents individual cost items or expenses associated with the project.
● Attributes: Id, ItemName, ItemDescription, Amount,CostCategoryId, ProjectId,
Date,EntryBy,ApprovedBy,Status
Member: Represents the members involved in the project.
● Attributes: Id,Email, Password, MemberName, Role, Department,Status
1. Create CRUD - API Endpoint for each Tables.
2. Make Report API for a Project cost with date range filter

## How to use 🤔

(1) Register a new member (api/v1/auth/register)
	After registration you will get a access token.

(2) If you are already registered, then you can login here (api/v1/auth/register)
    After login  you will get a access token


(3) Set the access token in root Authorization (Type : Bearer Token)

(4) Now you have access to Project, Cost Category, Cost Item & Member

(5) "Report API for a Project cost with date range filter" feature will be added soon.


👉 [You can decode your access token here](https://jwt.io/).
