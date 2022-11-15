# What-s-The-Weather-App
It is an android application through which we can get to know the current weather (such as temperature, rainfall, humidity, wind speed etc.) of any city in the world by just typing the city name. It  is made by the use of weather API and AsyncTask abstract class through which data is fetched from given URL through the Internet.

## Tools and Tech Stack Used:
Java, Android studio, scrapping, Async task viewer etc.

## Challenges:
Connect to weather API, download info from it, process that info and display only relevant info into the UI, that is, weather information about a particular city.

## Async Task:
It is a key tool used in this project. Async Task is an abstract class provided by Android which gives us the liberty to perform heavy tasks in the background and keep the UI thread light thus making the application more responsive. Android application runs on a single thread when launched. Heavy background processes can crash our app or activity if runs on the main thread i.e. UI thread. So, we use Async Task for that. By passing the **Weather API** as an string argument to the execute() function of Async Task class, we can connect to weather API. execute() function is to start the background thread.

Being an abstract class, Async Task contains two abstract functions **doInBackground()** and **onPostExecute()** which need to be implemented by overriding them.

i) doInBackground(): This method contains the code which needs to be executed in background. To notify that the background processing has been completed we just need to use the return statements.

ii) onPostExecute(): This method is called after doInBackground method completes processing. Result from doInBackground is passed to this method.

iii) JSON getString(): Returns the string value of the associated JSON String mapping for the specified name.

JSON: JSON stands for Javascript Object Notation. It is a light-weight data interchange format. It is the way in which data (or text) is formatted. Since JSON format is text only, it can easily be sent to and from a aserver. If we have data stored in a Javascript object then we can easily convert the object into JSON and then send to a server.

### SCREENSHOTS :-

![ScrShot1](https://user-images.githubusercontent.com/91591163/201943904-e48f8f22-5d45-436f-8036-fbd92af49089.jpg)

![ScrShot2](https://user-images.githubusercontent.com/91591163/201943909-c1322d76-4cef-4419-8410-8810277a0bc7.jpg)

![ScrShot3](https://user-images.githubusercontent.com/91591163/201943911-70061753-7b3d-4b54-b042-2f4e1ea433ed.jpg)

![ScrShot4](https://user-images.githubusercontent.com/91591163/201943916-86ade654-481a-4312-8b0e-44d4b5c9d81d.jpg)

![ScrShot5](https://user-images.githubusercontent.com/91591163/201943918-ca2db82b-845e-4b32-a2d6-ce1106d21686.jpg)
