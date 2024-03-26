# CSE3200 Midterm Timer Application 

This application follows the model-view-controller pattern.

Model: CenterScreenViewModel, LeftScreenViewModel, and RightScreenViewModel classes are the model.

View: CenterScreen, MainScreen, LeftScreen, and RightScreen composables are the View. 

Controller: CenterScreenViewModel, LeftScreenViewModel, and RightScreenViewModel classes are the Controller

To run application, clone into SuchithaMisra_Timer_MidtermProject repository. 

How App works: When run, the user will be prompted with three buttons: View First Screen, View Second Screen, and View Third Screen. Click into desired screen and stopwatch will appear with Start, Stop/Pause, and Redo button. Simply click Start button to begin stopwatch. To go back to main screen to view remaining two screens simply press the back button on the android phone (triangle button). Do the same to start remaining timers on other screens. While the stopwatch is running, the Stop button will change to Pause and go back to Stop when redo button is pressed. Notice, the timer will still be running as long as the Stop button is not clicked on. The app timers also handle rotation. 
