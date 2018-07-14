base project with hello rest.
If you run as main class "CollegeApplication" as boot application and hit the url
url : http://localhost:9001/coll/hello
output : Greetings from Employee Spring Boot!

url for first student using mapsturct dto:
url : http://localhost:9001/coll/getAllStudents
output : {"response":[{"studentId":"1","firstName":"fstname","lastName":"lstname","fullName":"fstname lstname","country":"India"}],"success":true,"errorCode":null,"message":"student list fetched successfully"}