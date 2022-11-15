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

![ScrShot1](https://drive.google.com/file/d/1nXtT7chQ5yb5K3Gn8TTXjz2RS_xaOOxc/view?usp=share_link)

