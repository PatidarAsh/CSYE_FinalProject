# CSYE6200_FinalProject
This is a word puzzle game, made for entertainment as well as to test ability with english languge 

## Environmental setup(Highly recommended)
1. Import the source code into Eclipse by using File > open projects from file system > import source, use the directory to select project folder.
2. Configration settings:
    - On the menu, project > properties > Java Build Path > libraries, add Javafx jars and Javafx SDK into modulepath.
    - Delete javafx module info if exists.
## Running the project
1. Click run.
    - If the project crashes in the terminal, setting the running configurations may be needed
    - Under run menu > run configuration > Java Application > Arguments add:
    ```
    --add-modules javafx.controls,javafx.fxml,javafx.media
    ```
    - Unselect all three usage boxes
2. Once lunch, click the cat image to see the instructions
3. Time to play!

## Credits to 
[Jasmine Chen](https://github.com/JasmnC), [Ashvini Patidar](https://github.com/PatidarAsh), and [Mitali Chouthai](https://github.com/MitaliChouthai)
