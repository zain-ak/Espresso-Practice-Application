<h1>Android Espresso Practice Application <img src="https://camo.githubusercontent.com/737e7380383ffcd2f3b9bf55c678f3b368feb730/68747470733a2f2f6c68352e676f6f676c6575736572636f6e74656e742e636f6d2f2d453259504c6c56416c30552f564a556350726756432d492f414141414141414147464d2f416b715a6e354e387272632f773839302d68313030392f657370726573736f5f6c6f636b75702e706e67" height="75" width="50" /></h1> 

A Java-based Android Application for learning the Espresso framework for UI Testing. The course ['Android Espresso Essential Training'](https://www.lynda.com/Android-tutorials/Android-Espresso-Essential-Training/688523-2.html) by Chiu-Ki Chan was followed for this project. Instead of making different projects for each chapter as is done in the videos, everything was integrated into one project. This allowed me to go a little further in terms of the Espresso tests written, and I'll point this out as I go along.

Espresso is a UI testing framework used in Android development for writing instrumentation tests (tests for *exercising* the UI). This allows developers to check whether their code is working correctly based on certain inputs into the app vs. re-running the application and manually inputting information. 

Basic setup instructions can be found here [here](goo.gl/HpLmwX "Espresso Setup Guide")

<h4>Project Overview</h4>
The relevant project files are `MainActivity.java` and `RecyclerViewActivity.java`. Espresso test files are included in `src` > `androidTest` > `java` > *package name*; these files are named according to the activities which are being tested. So for this project the files are `MainActivityTest.java` and `RecyclerViewActivityTest.java`. 

* `MainActivity.java` is the primary file in the project. It tests simple user inputs such as a button click and the changes that follow. The corresponding test file, `MainActivityTest.java` is used for running instrumentation tests on this file and those tests will be summarized briefly below:

...*```java public void greeting() ```: the first function implemented which tests a `TextView greeting_view`, and a `Button greeting_btn`. When the app opens, `greeting_view` should be empty, and once `greeting_btn` is clicked, it should be disabled and `greeting_view` is given the text 'Well, well, well...'.

There is also a file called `MainActivityTestRecorded.java`. This file was created using the *Record Espresso Test* just to see the automatic testing that is built into Android Studio. This testing is useful for quick tests that aren't too complex, and also a handy reference when you're struggling to write your own test, since it generates the code which is usually much more precise in regards to user input. An example is when a user clicks the screen, Espresso Recorder will save the exact co-ordinates where the click was made and use these co-ordinates in all subsequent runs. Much of the code generated here is not required, the Espresso framework can work with much less information and still run tests correctly. 

