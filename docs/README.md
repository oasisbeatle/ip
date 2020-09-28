# User Guide

## Introduction

Donald is a task manager. He allows you to create and maintain a list of tasks. Happy tasking!

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Follow the instructions on downloading the latest version of `Donald` from [here](http://link.to/duke).

## Features 

### Add `Task`
Add three types of tasks: Todo tasks, Deadline tasks and Event tasks. Todo tasks don't require time but events and deadlines do.

### Done `Task`
Mark a task as done.

### List 
List all of the tasks added.

### Delete `Task`
Deletes a task 

### Find `Task`
Finds a task by a particular given keyword.

## Usage 

`:bulb: NAME is the name of the task we wish to add`

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo TODO_NAME`

Create a todo to sleep: `todo sleep`

### Adding a deadline: `deadline`
Adds a new item to the list of deadline items.

Format: `deadline DEADLINE_NAME /by dd/MM/yyyy HH:mm`

Create a deadline to submit CS assignment by 3rd October, 2020, 23:59: `deadline CS assignment /by 03/10/2020 23:59`

### Adding an event: `event`
Adds a new item to the list of event items.

Format: `event EVENT_NAME /at dd/MM/yyyy HH:mm`

Create an event to attend Christmas mass at 25th December, 2020, 23:00: `event Xmas mass /at 25/12/2020 23:00`

### Marking task as done: `task`
Marks a task at a particular index as done

Format: `done INDEX`

Mark the task number 2 as done: `done 2`

### Listing all the tasks `list`
Lists all of the tasks currently in the list

Format: `list`

List all of the tasks: `list`

### Deleting a task: `delete`
Deletes a task at a particular index

Format: `delete INDEX`

Delete task number 1: `delete 1`

### Finding a task: `find`
Finds a task given a particular keyword

Format: `find KEYWORD`

Find a task using the keyword 'sleep': `find sleep`


## Command Summary

Command | Format | Usage
--------|--------|------
todo | todo TODO_NAME | todo sleep
deadline | deadline DEADLINE_NAME /by dd/MM/yyyy HH:mm | deadline CS assignment /by 03/10/2020 23:59
event | event EVENT_NAME /at dd/MM/yyyy HH:mm | event Xmas mass /at 25/12/2020 23:00
done | done INDEX | done 2
list | list | list
delete | delete INDEX | delete 1
find | find KEYWORD | find sleep
