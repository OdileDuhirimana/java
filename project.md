1.​ INTEGRATED SITUATION:
Situation
Rwanda Revenue Authority (RRA), is a government revenue collection agency
established by the Parliament of Rwanda. It has its head offices in Kigali. As a
full stack developer, you have been hired to develop for them a vehicle tracking
management system as described below.
They want to be able to track different people who owned a certain vehicle over
a number of year from the time it was registered in Rwanda. During the vehicle
registration these details are required; chassis number, manufacture company,
manufacture year, price and model name eg (AN12334, Toyota, 2005, 13
million, Toyota RAV4).
The vehicle is linked to owner whose minimum details captured are; owner
names, owner national ID, owner phone number and owner address. The car
also receive a plate number of the vehicle owner. Owner can have one or even
multiple plate numbers as s/he buy a another car. When registered a plate
number these details are required, Owner, plate number and issued Date.
1TASKS:
As a Java developer, you have been hired to develop for them a Backend for
vehicle tracking management system with these minimum features:
Task 1: User Management
●​ Users have names, email, phone and national id, password and roles(
ROLE_ADMIN, ROLE_STANDARD)
●​ Allow users to sign up
●​ Allow to login using into the system after signing up
Task 2: Vehicle Owners and Plate numbers
-​ Allow admin to register car owner with above mentioned details
-​ Perform display of the people owning a car in the system
-​ Enable Search by National Id, by email, by mobile number
-​ Register plate number under a specific Owner
-​ Display plate numbers associated with a given Owner
Task 3: Vehicle registration
-​ Allow admin to register the vehicle with details highlighted above on a
specific owner and platenumber,
-​ Allow display of the details.
Task 4:Vehicle transfer:
-​ Allow admin to transfer the vehicle from one registered user to
another, the admin should capture even the amount of money at which
the new owner is buying it.
-​ Every time a transfer is performed the existing platenumber should
mark re as available status and be given a new platenumber from the
new Owner platenumbers list. A plate number (inuse status) assigned
to a car can not be used to another until the car is transferred.
-​ Allow admin to search the vehicle by owner’s national id, plate number
or vehicle’s chassis number
Task 5: History of Vehicle ownership:
-​ Allow admin to displaying history of how a vehicle identified by either
number plate or chassis number has been owned from one owner to
another.
2-​ The system should show who owned the vehicle when, how much each
owner bought it for.
Technical specifications:
●​ You should build backend using java spring boot
●​ You should either use MySQL or Postgresql as DBMS
●​ You should document your backend APIs with swagger UI
●​ You should use JWT in authorization and authentication
●​ Apart from Signup APIs others should be accessed by a logged in
admins.
●​ Ensure record are displayed in a paginated manner
●​ Display logs properly
●​ Handle exceptions and validations properly