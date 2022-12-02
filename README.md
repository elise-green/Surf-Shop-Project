# Surf Rental Application

## App description

    
A app that can be used at a surf rental shop to show the equipment that is currently available and the equipment 
that is being rented out. It allows you to rent a piece of equipment out, return a piece of equipment, and buy a new 
piece of equipment. It will also have the option to give the price for the amount of time rented, and the total profit  
for the shop. This project is of interest to me as surfing is one of my hobbies and I think it would be interesting to 
design an application that could be useful for a business.


 ## Equipment Type  list:
- **Surfboards**
- **Wetsuits**
- **Booties**

## Surfboards
The different types of surfboards and for each type the length of the board, the price, and the stock of that board.

**Soft Top lengths**:
- 10 ft
- 9 ft
- 8 ft
- 7 ft

**Original lengths**:
- 9 ft
- 8 ft
- 7 ft
- 6 ft


## Wetsuits
The different categories of wetsuit and for each type size, the price, and the stock of that size.

**Men's Wetsuit Sizes**:
- XS
- S
- M
- L 
- XL

**Women's Wetsuit Sizes**:
- XS
- S
- M
- L
- XL

**Children's Wetsuit Sizes**:
- XS
- S
- M
- L
- XL

## Booties 
The different categories of booties and for each type size, the price, and the stock of that size.

**Men's Bootie Sizes**:
- XS
- S
- M
- L
- XL

**Women's Bootie Sizes**:
- XS
- S
- M
- L
- XL

**Children's Bootie Sizes**:
- XS
- S
- M
- L
- XL


## User Stories:
- As a user I want to be able to see the list of rented out equipment.
- As a user I want to be able to add a piece of equipment to the rented list.
- As a user I want to be able to print a list of all the available equipment.
- As a user I want to be able to get the price of the gear selected for a specific time.
- As a user I want to be able to add a piece of equipment to the inventory.
- As a user I want to be able to save the stock and rented equipment to the file.
- As a user I want to be able to be able to reload stock amd rented and resume where I was.

# Instructions for Grader

- You can generate the first required event related to adding Xs to a Y by clicking the Add Equipment tab and then 
pressing one of the three buttons and then selecting a type and size on the popup menu and then pressing the add button

- You can generate the second required event related to adding Xs to a Y by clicking the Rent Equipment tab and then
pressing one of the three buttons and then selecting a type and size on the popup menu and then pressing the add button
- You can locate my visual component by clicking the main tab
- You can save the state of my application by pressing the save button on the main tab
- You can reload the state of my application by pressing the the load button on the main tab

# Phase 4 : Task 2
This is what is printed on the consul when I run the GUI and add a surfboard, wetsuit, and booties, and then rent
a surfboard

Thu Dec 01 13:06:54 PST 2022
New Surfboard added
Thu Dec 01 13:06:59 PST 2022
New Wetsuit added
Thu Dec 01 13:07:05 PST 2022
New Booties added
Thu Dec 01 13:07:11 PST 2022
New Surfboard rented

# Phase 4: Task 3
Looking at my UML and my code on change I would really like to make is an super class for AddEquipment and RentEquipment.
As you can see in the UML the classes have the same associations and in the code they also essentially have to same 
methods with the exception of the one class adds a piece of equipment and the other rents and the buttons have different 
labels. 