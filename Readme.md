// TODO Organize readme file

# Home / Contas do Lar

This app is designed to help me on my home automation.

The first step is to help me controlling my expenses and bills.
Some details of this project will be shown here once the screens get implemented.

Other steps like irrigation automation will be developed in the future.

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
- For DataSource we are using a NoSQL database with cached local storage and transparent sync with remote storage (Firestore).

### Web
- It will be my first project with kotlin to web, so I still have to learn how to configure and make it run.

### iOS
- I really wanted to make this project to compile for iOS as well, but there is a big problem: I don't own a Mac.
- I've attempted to use Bitrise in order to generate iOS builds, but it failed, was too complicated to investigate/solve.
- This is still on backlog, if I can manage to have access to a Mac in order to fix the build I will work on this. Any external help is always welcome.



## About the team
- Me, Myself & I.
- Since I'm a developer, the processes to build this app are different from usual companies.
-- Product requests are written on a paper
-- This is projected to have only me and my girlfriend as users
-- Design preview is just a scratch on a paper as well
-- There is no boards with tasks. I develop based on what comes to my mind. Sometimes it's organizing the project, other times it's rushing a new feature. There's also a lot of researches about new libs.
-- It would be a waste of my time to organize the backlog and ideas since I'm the only stakeholder. My target is to have a MVP running on multiplatforms and use it to show my knowledge and programming skills.
-- I'm not using TDD until the project setup is done. This includes managing modules structures, libraries definitions and basic app running. For new features I expect to have automated tests covering main parts of the app.
-- It's been a great pleasure to develop this. I hope you enjoy :)
