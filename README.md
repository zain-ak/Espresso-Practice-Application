<h1>Android Espresso Practice Application <img src="https://camo.githubusercontent.com/737e7380383ffcd2f3b9bf55c678f3b368feb730/68747470733a2f2f6c68352e676f6f676c6575736572636f6e74656e742e636f6d2f2d453259504c6c56416c30552f564a556350726756432d492f414141414141414147464d2f416b715a6e354e387272632f773839302d68313030392f657370726573736f5f6c6f636b75702e706e67" height="125" width="110" /></h1> 

A Java-based Android Application for learning the Espresso framework for UI Testing. The course ['Android Espresso Essential Training'](https://www.lynda.com/Android-tutorials/Android-Espresso-Essential-Training/688523-2.html) by Chiu-Ki Chan was followed for this project. Instead of making different projects for each chapter as is done in the videos, everything was integrated into one project. This allowed me to go a little further in terms of the Espresso tests written, and I'll point this out as I go along.

Espresso is a UI testing framework used in Android development for writing instrumentation tests (tests for *exercising* the UI). This allows developers to check whether their code is working correctly based on certain inputs into the app vs. re-running the application and manually inputting information. 

Basic setup instructions can be found here [here](goo.gl/HpLmwX "Espresso Setup Guide")

<h3>Project Overview</h3>
The relevant project files are `MainActivity.java` and `RecyclerViewActivity.java`. Espresso test files are included in `src` > `androidTest` > `java` > _package name_ ; these files are named according to the activities which are being tested. So for this project the files are `MainActivityTest.java` and `RecyclerViewActivityTest.java`. 
<br>
The test files have some code in them that differentiates them from normal class files:
* The first is the annotation `@RunWith(AndroidJUnit4::class)` (or `@RunWith(AndroidJUnit4.class)` for Java) which signifies that the tests in this class are all Android tests. 
* An `ActivityTestRule` has to be added next, and this is to tell Espresso which activity to test for the methods that follow. This is essentially a linking of the test file and the normal activity file. 
* There is always an `@Rule` annotation above an ActivityTestRule which serves to say that this is a JUnit test rule. Another annotation that could be used is `@JVMField` which is Kotlin specific; this is used if the tests are being written in Kotlin. 
* Each test method will be annotated by `@Test`.

The conventional Espresso formula used for testing is:
```java
onView(viewMatcher) //Used to locate the view by id
    perform(ViewAction) //performing an action on the view, a click for example
    check(ViewAssertion) //check that the action performed results in the correct output
```
The methods used below follow this conventional formula and apply to most Views in Android:

-...```public void greeting()```: the first function implemented which tests a `TextView greeting_view`, and a `Button greeting_btn`. When the app opens, `greeting_view` should be empty, and once `greeting_btn` is clicked, it should be disabled and `greeting_view` is given the text _'Well, well, well...'._

-...```public void toolbarTitle()```: Checks the toolbar title of the application. The commented out section is one way to check the title, but it can have issues due to overspecification (this reduces the robustness of the code in case Google were to change layout specifications in the future). Instead, it's better to use `BoundedMatcher` which allows the developer to supply their own match criteria. The word _Bounded_ implies that the criteria applies to a specific class, in the case of this function that is `Toolbar`.

...- The matcher is written below this function, and implements two methods called matchesSafely() and describeTo(). matchesSafely() is the criteria checker and returns a true/false. describeTo() describes the nature of the problem in the case false is returned.
    
...- These are the methods that will be implemented in any `BoundedMatcher`. 

There is also a file called `MainActivityTestRecorded.java`. This file was created using the *Record Espresso Test* just to see the automatic testing that is built into Android Studio. This testing is useful for quick tests that aren't too complex, and also a handy reference when you're struggling to write your own test, since it generates the code which is usually much more precise in regards to user input. An example is when a user clicks the screen, Espresso Recorder will save the exact co-ordinates where the click was made and use these co-ordinates in all subsequent runs. Much of the code generated here is not required, the Espresso framework can work with much less information and still run tests correctly. 

