# USE CASE: 11 Produce a report of list of cities in a district sorted by largest population to smallest
## CHARACTERISTIC INFORMATION
### Goal in Context
As an employee of the organization, I want to produce a report of list of cities in a district sorted by largest population to smallest so that the organization can report that information.

### Scope
Organization.

### Level
Primary task.

### Preconditions
Database (world.sql) contains data that needed for report.

### Success End Condition
A report is available for organization to view.

### Failed End Condition
No report is produced.

### Primary Actor
Organization's employee.

### Trigger
When organization's employee want to see the report.

### MAIN SUCCESS SCENARIO
* Organization's employee request report about cities information by largest population to smallest in the district.
* The system pull the data from the database and provide the requested report information.

### EXTENSIONS
District does not exist:
system inform the organization.

### SUB-VARIATIONS
None.

### SCHEDULE
DUE DATE: Release v01.0.2-alpha
