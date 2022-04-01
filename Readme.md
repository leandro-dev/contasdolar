# Leandro's Home

This app is designed to help me on my home automation and daily tasks.

The first step is to help me controlling my expenses and bills.
The next step is to setup an integration with Raspberry Pi to water my plants and control/monitor through this app.

I also want to use this project to test some new technologies and to be my showcase.

## Quick Overview
![Icon (1)](https://user-images.githubusercontent.com/1706622/128160651-e2377574-d79b-4a99-90e7-f8b5b9b97304.png)

I would like to apologize for my terrible design skills, but I hope you got the references from the icon :)

It is being build with multiple modules, following the structure:
![image](https://user-images.githubusercontent.com/1706622/161262299-0a5bb871-a466-4014-830f-f38d3354ce6d.png)

Currently the app has only 2 screens, to work as a demo while I setup the multiplatform environment. 
|SignIn|WalletList|
|-------|-------|
|![image](https://user-images.githubusercontent.com/1706622/161261001-c5c9663e-52d5-476a-8827-4fc2fba5384d.png)|![image](https://user-images.githubusercontent.com/1706622/161261050-e9193c95-78c9-41bc-b36d-62743798a8f5.png)|


## For developers

This project is designed to be multiplatform with kotlin.
The official Jetbrains libraries, such as kotlin, coroutines, datetime, will be accessible to all modules, like aspects.
Other unofficial libraries, such as Firebase-kotlin-sdk (dev.gitlive) will be encapsulated in order to abstract and help future refactors.

The only exception for the time being is for Dependency Injection library, because it is very hard to abstract. Different libraries such as Koin, Dagger, Kodein, have a very different syntax.
The reason for choosing Kodein is because it targets several platforms on kotlin multiplatform projects.

### Android
My main speciality is as Android Developer. I'm attempting to use only recent launched libraries and explore them.

App Layers:
- For View we are using Android Compose only.
- For ViewModel, we are using an adaptation in order to make it reusable for multiplatform.
- There is a business layer to manage some in-app rules.
- For DataSource we are using a NoSQL database with cached local storage and automatic background sync with remote storage (Firestore).

### Web
- It will be my first project with kotlin to web, so I still have to learn how to configure and make it run.

### iOS
- I really wanted to make this project to compile for iOS as well, but there is a big problem: I don't own a Mac.
- I've attempted to use Bitrise in order to generate iOS builds, but it failed, was too complicated to investigate/solve.
- This is still on backlog, if I can manage to have access to a Mac in order to fix the build I will work on this. Any external help is always welcome.
- My next attempt will be using the plugin "Code with me" and asking a friends help.


### IDE issues
I've experienced the IDE AndroidStudio Bumblebee showing false messages about compilations issues of the module "platforms".
This must be related to the way the plugins are defined, but the project succeeds to sync and compile.
If that's your case, close the project, delete ".idea" folder from root project then reopen it.


## About the team
- Me, Myself & I.
- Since I'm a developer, the processes to build this app are different from usual companies.
  - There is a board to register the next steps
  - This is projected to have only me and my girlfriend as users
  - Design preview is just a scratch on a paper
  - I develop based on what comes to my mind. Sometimes it's organizing the project, other times it's rushing a new feature. There's also a lot of researches about new libs.
  - My target is to have a MVP running on multiplatforms and use it to show my knowledge and programming skills.
  - I'm not using TDD until the project setup is done. This includes managing modules structures, libraries definitions and basic app running. For new features I expect to have automated tests covering main parts of the app.
  - It's been a great pleasure to develop this. I hope you enjoy :)
