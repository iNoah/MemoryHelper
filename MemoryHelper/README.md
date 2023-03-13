# MemoryHelper
MemoryHelper is a Java app that displays text from a file in a small window on the desktop. The app is useful for displaying information that you need to remember, such as new vocabulary and terms.

# Features
- Displays a 320x320 window with a grid layout and two lines.
- Reads data from a text file with two columns separated by a "|".
- Displays the text from the first column in the upper area and the text from the second column in the lower area.
- Automatically cycles through each line of text in the file, displaying each one for a specified amount of time.
- Can be configured to run on top of other windows.
# Usage
To use MemoryHelper, follow these steps:

1. Create a text file with the data you want to display. The file should have two columns separated by "|".
2. Start the app by running the MemoryHelper class.
3. When prompted, enter the amount of time you want each line to be displayed for in seconds.
4. The app will display the text from the first column in the upper area and the text from the second column in the lower area.
5. The app will automatically cycle through each line in the file, displaying each one for the specified amount of time.
# Customization
The MemoryHelper class can be customized to suit your needs. For example, you can change the font size of the text by modifying the setFont method calls in the constructor. You can also change the size and layout of the window by modifying the setSize and setLayout method calls in the constructor.

# Dependencies
MemoryHelper requires Java 8 or later to run.

# License
MemoryHelper is licensed under the MIT License. See the LICENSE file for details.