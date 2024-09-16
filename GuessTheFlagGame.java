import java.awt.*; //for Frame
import javax.swing.*; //for JLabel
import javax.swing.border.Border; //for border
import java.awt.event.*; //for event handling

class GuessTheFlagGame extends Frame implements ActionListener {

    String fileNamesArr[] = { "Australia.png", "France.png", "India.png", "United Kingdom.png", "United States.png" }; // stores
                                                                                                                       // the
                                                                                                                       // filenames
                                                                                                                       // of
                                                                                                                       // all
                                                                                                                       // flags'
                                                                                                                       // images
                                                                                                                       // (Files
                                                                                                                       // are
                                                                                                                       // in
                                                                                                                       // the
                                                                                                                       // same
                                                                                                                       // folder
                                                                                                                       // as
                                                                                                                       // the
                                                                                                                       // class)

    Color backgroundColorBlack = new Color(28, 27, 31); // creates a background color. rgb values:- red:28, green:27,
                                                        // blue: 31

    Font defaultFont = new Font("Calibri", 1, 18); // creates a default font. Font name: Calibri, Font style: 1 (BOLD),
                                                   // Font size: 18

    Color textColorLavender = new Color(202, 196, 208); // creates a text color. rgb values:- red:202, green:196, blue:
                                                        // 208

    Color backgroundColorLavender = new Color(234, 221, 255); // creates a background color. rgb values:- red:234,
                                                              // green:221, blue: 255

    Color textColorDarkPurple = new Color(73, 37, 50); // creates a text color. rgb values:- red:73, green:37, blue: 50

    Color backgroundColorPurple = new Color(208, 188, 255); // creates a background color. rgb values:- red:208,
                                                            // green:188, blue: 255

    Color whiteColor = new Color(255, 255, 255); // creates a border and text color. rgb values:- red:255, green:255,
                                                 // blue: 255

    Label headerLabel; // displays "Which country's flag is shown below?"

    Label answerStatusLabel; // displays "Correct answer" or "Incorrect answer"

    Label correctAnswerLabel; // displays the correct answer incase the user gives a wrong answer

    Label scoreLabel; // displays the score

    Button goToNextFlagButton; // go to the next flag after the user has submitted an answer for the current
                               // flag

    Panel southPanel; // a container for TextField, Buttons, Labels.

    TextField inputAnswerTextField; // accepts answer as an input from the user

    JLabel labelOfFlagImage; // displays the flag by assigning an image as the icon for itself

    Button submitButton; // submit an answer

    String currentFlagFileName; // stores the file name of the current flag's image

    ImageIcon flagImageIcon; // icon to assign to JLabel labelOfFlagImage

    int correctAnswersCount; // stores count of correct answers

    int wrongAnswersCount; // stores count of wrong answers

    public GuessTheFlagGame() { // calls init methods of all components

        initFrame(); // initializes the Frame

        initHeaderLabel(); // initializes Label headerLabel

        initLabelOfFlagImage(); // initializes JLabel labelOfFlagImage

        initSouthPanel(); // initializes Panel southPanel

        initInputAnswerTextField(); // initializes TextField inputAnswerTextField

        initSubmitButton(); // initializes Button submitButton

        initAnswerStatusLabel(); // initializes Label answerStatusLabel

        initScoreLabel(); // initializes Label scoreLabel

        initCorrectAnswerLabel(); // initializes Label correctAnswerLabel

        initGoToNextFlagButton(); // initializes Button goToNextFlagButton
    }

    void initFrame() { // initializes the Frame

        setBackground(backgroundColorBlack); // sets the background color to the specified object of class Color
        setFont(defaultFont); // sets the font to the specified object of class Font
        BorderLayout borderLayout = new BorderLayout(20, 20); // displays components in a border layout with the
                                                              // specified horizontal and vertical gaps between
                                                              // components
        setLayout(borderLayout); // sets the layout to the specified object of class BorderLayout
        setTitle("Guess The Flag"); // sets the title of the frame to "Guess The Flag"
        setResizable(false); // disables resizing of the frame (window). This is done to prevent the images
                             // of the flags from being cropped.
    }

    void initHeaderLabel() { // initializes Label headerLabel

        headerLabel = new Label(); // creates object of class Label
        headerLabel.setAlignment(Label.CENTER); // sets the alignment to center
        headerLabel.setBackground(backgroundColorBlack); // sets the background color to the specified object of class
                                                         // Color
        Font headerFont = new Font("Calibri", 1, 24); // creates a header font. Font name: Calibri, Font style: 1
                                                      // (BOLD), Font size: 24
        headerLabel.setFont(headerFont); // sets the font to the specified object of class Font
        headerLabel.setForeground(textColorLavender); // sets the text color to the specified object of class Color
        headerLabel.setText("Which country's flag is shown below?"); // displays "Which country's flag is shown below?"
                                                                     // on the label
        add(headerLabel, BorderLayout.NORTH); // adds the component to the north section of the frame
    }

    void initLabelOfFlagImage() { // initializes JLabel labelOfFlagImage

        labelOfFlagImage = new JLabel(); // creates object of class JLabel
        Border whiteBorder = BorderFactory.createLineBorder(whiteColor); // creates a line border with the specified
                                                                         // object of class Color.
        labelOfFlagImage.setBorder(whiteBorder); // sets the border to the specified object of class Border
        displayFlag(); // displays a randomly selected image of a flag
        labelOfFlagImage.setHorizontalAlignment(SwingConstants.CENTER); // sets the horizontal alignment the contents of
                                                                        // the JLabel to CENTER
        labelOfFlagImage.setVerticalAlignment(SwingConstants.CENTER); // sets the vertically alignment the contents of
                                                                      // the JLabel to CENTER
        add(labelOfFlagImage, BorderLayout.CENTER); // adds the component to the center section of the frame
    }

    void displayFlag() { // display a randomly selected image of a flag by setting it as icon of
                         // labelOfFlagImage

        int min = 0; // stores minimum value to generate
        int max = 5; // stores maximum value to generate + 1 i.e. to generate numbers till 4, store 5
                     // in int max
        int randomIndex; // stores a randomly generated index

        while (true) { // generates a random index which has not been used before
            randomIndex = (int) ((Math.random() * (max - min)) + min); // Math.random() returns a random double value
                                                                       // greater than or equal to 0.0 and less than 1.0
                                                                       // which is then multiplied by the magnitude of
                                                                       // the range i.e. (max - min)) + min)

            if (fileNamesArr[randomIndex] != null) { // checks if the index generated has been used before (the value at
                                                     // the index will be null)
                break; // stop if the value at the index is not null i.e. the index has not been used
                       // before
            }
        }

        currentFlagFileName = fileNamesArr[randomIndex]; // assigns the file name of the current flag
        fileNamesArr[randomIndex] = null; // current value in fileNamesArr needs to be null so that it is not used again

        flagImageIcon = new ImageIcon(currentFlagFileName); // creates object of class ImageIcon with the specified
                                                            // filename
        labelOfFlagImage.setIcon(flagImageIcon); // displays the icon of the flag on the jLabel
    }

    void initSouthPanel() { // initializes Panel southPanel

        southPanel = new Panel(); // creates object of class Panel
        southPanel.setBackground(backgroundColorBlack); // sets the background color to the specified object of class
                                                        // Color
        southPanel.setFont(defaultFont); // sets the font to the specified object of class Font
        southPanel.setForeground(textColorLavender); // sets the text color to the specified object of class Color
        GridLayout gridLayout = new GridLayout(3, 2, 20, 20); // displays components in a grid layout of size: 3 rows
                                                              // and 2 columns with the specified horizontal and
                                                              // vertical gaps between the components
        southPanel.setLayout(gridLayout); // sets the layout to the specified object of class GridLayout
        add(southPanel, BorderLayout.SOUTH); // adds the component to the south section of the frame
    }

    void initInputAnswerTextField() { // initializes TextField inputAnswerTextField

        inputAnswerTextField = new TextField(); // creates object of class TextField
        inputAnswerTextField.setBackground(backgroundColorLavender); // sets the background color to the specified
                                                                     // object of class Color
        inputAnswerTextField.setFont(defaultFont); // sets the font to the specified object of class Font
        inputAnswerTextField.setForeground(textColorDarkPurple); // sets the text color to the specified object of class
                                                                 // Color
        inputAnswerTextField.setText("Type your answer here"); // displays "Type your answer here" on the TextField
        southPanel.add(inputAnswerTextField); // adds the component to the grid layout
    }

    void initSubmitButton() { // initializes Button submitButton

        submitButton = new Button(); // creates object of class Button
        submitButton.setBackground(backgroundColorPurple); // sets the background color to the specified object of class
                                                           // Color
        submitButton.setFont(defaultFont); // sets the font to the specified object of class Font
        submitButton.setForeground(textColorDarkPurple); // sets the text color to the specified object of class Color
        submitButton.setLabel("Submit"); // displays "Submit" on the button
        submitButton.addActionListener(this); // adds an action listener to the button, used for submitting the answer
        southPanel.add(submitButton); // adds the component to the grid layout
    }

    void initAnswerStatusLabel() { // initializes Label answerStatusLabel

        answerStatusLabel = new Label(); // creates object of class Label
        answerStatusLabel.setAlignment(Label.CENTER); // sets the alignment to center
        answerStatusLabel.setBackground(backgroundColorLavender); // sets the background color to the specified object
                                                                  // of class Color
        answerStatusLabel.setFont(defaultFont); // sets the font to the specified object of class Font
        answerStatusLabel.setForeground(textColorDarkPurple); // sets the text color to the specified object of class
                                                              // Color
        answerStatusLabel.setText(""); // displays "" on the label
        answerStatusLabel.setVisible(false); // the label is not visible
        southPanel.add(answerStatusLabel); // adds the component to the grid layout
    }

    void initScoreLabel() {

        scoreLabel = new Label(); // creates object of class Label
        scoreLabel.setAlignment(Label.CENTER); // sets the alignment to center
        scoreLabel.setBackground(backgroundColorLavender); // sets the background color to the specified object of class
                                                           // Color
        scoreLabel.setFont(defaultFont); // sets the font to the specified object of class Font
        scoreLabel.setForeground(textColorDarkPurple); // sets the text color to the specified object of class Color
        scoreLabel.setText(correctAnswersCount + " Correct " + wrongAnswersCount + " Wrong "); // displays the score on
                                                                                               // the Label
        southPanel.add(scoreLabel); // adds the component to the grid layout
    }

    void initCorrectAnswerLabel() { // initializes Label scoreLabel

        correctAnswerLabel = new Label(); // creates object of class Label
        correctAnswerLabel.setAlignment(Label.CENTER); // sets the alignment to center
        correctAnswerLabel.setBackground(backgroundColorLavender); // sets the background color to the specified object
                                                                   // of class Color
        correctAnswerLabel.setFont(defaultFont); // sets the font to the specified object of class Font
        correctAnswerLabel.setForeground(textColorDarkPurple); // sets the text color to the specified object of class
                                                               // Color
        correctAnswerLabel.setText(""); // displays "" on the label
        correctAnswerLabel.setVisible(false); // the label is not visible
        southPanel.add(correctAnswerLabel); // adds the component to the grid layout
    }

    void initGoToNextFlagButton() { // initializes Label correctAnswerLabel

        goToNextFlagButton = new Button("Go to next flag"); // creates object of class Button and displays "Go to next
                                                            // flag" on the button
        goToNextFlagButton.setBackground(backgroundColorPurple); // sets the background color to the specified object of
                                                                 // class Color
        goToNextFlagButton.setFont(defaultFont); // sets the font to the specified object of class Font
        goToNextFlagButton.setForeground(textColorDarkPurple); // sets the text color to the specified object of class
                                                               // Color
        goToNextFlagButton.setEnabled(false); // disables the button
        goToNextFlagButton.addActionListener(this); // adds an action listener to the button, used for submitting the
                                                    // answer
        southPanel.add(goToNextFlagButton); // adds the component to the grid layout
    }

    public void actionPerformed(ActionEvent event) { // event handling for submit button and goto next flag button

        if (event.getSource() == submitButton) { // if submit button is clicked
            submitButtonActionPerformed(); // event handling for submit button clicked
        }
        if (event.getSource() == goToNextFlagButton) { // if go to next flag button was clicked
            goToNextFlagButtonActionPerformed(); // event handling for go to next flag button clicked
        }
    }

    void submitButtonActionPerformed() { // evaluates answer, calculates score, displays answer status, scores and the
                                         // correct answer incase the user gives a wrong answer

        submitButton.setEnabled(false); // disables submit button so that there is only 1 attempt to answer for 1 flag

        inputAnswerTextField.setEditable(false); // disables input field so that answer is not changed

        String answerEntered = inputAnswerTextField.getText(); // stores the answer entered by the user

        int currentFlagFileNameLength = currentFlagFileName.length(); // stores the length of the file name of the
                                                                      // current flag's image

        String correctAnswer = currentFlagFileName.substring(0, currentFlagFileNameLength - 4); // correct answer is the
                                                                                                // substring of the
                                                                                                // filename i.e. remove
                                                                                                // ".png" from the
                                                                                                // filename to get the
                                                                                                // correct answer

        if (answerEntered.equalsIgnoreCase(correctAnswer)) { // correct answer

            correctAnswersCount++; // increments count of correct answers

            scoreLabel.setText(correctAnswersCount + " Correct " + wrongAnswersCount + " Wrong "); // displays the score

            Color backgroundColorGreen = new Color(120, 198, 58); // creates a background color. rgb values:- red:120,
                                                                  // green:198, blue: 58
            answerStatusLabel.setBackground(backgroundColorGreen); // sets the background color to the specified object
                                                                   // of class Color
            answerStatusLabel.setForeground(whiteColor); // sets the text color to the specified object of class Color
            answerStatusLabel.setText("Correct answer"); // displays "Correct answer"
            answerStatusLabel.setVisible(true); // displays "Correct answer" in white color on a green color background
        } else { // wrong answer

            wrongAnswersCount++; // increments count of wrong answers

            scoreLabel.setText(correctAnswersCount + " Correct " + wrongAnswersCount + " Wrong "); // displays the score

            Color backgroundColorRed = new Color(179, 38, 30); // creates a background color. rgb values:- red:179,
                                                               // green:38, blue: 30
            answerStatusLabel.setBackground(backgroundColorRed); // sets the background color to the specified object of
                                                                 // class Color
            answerStatusLabel.setForeground(whiteColor); // sets the text color to the specified object of class Color
            answerStatusLabel.setText("Incorrect answer"); // displays "Incorrect answer"
            answerStatusLabel.setVisible(true); // displays "Incorrect answer" in white color on a red color background

            correctAnswerLabel.setText("Correct answer = " + correctAnswer); // displays the correct answer
            correctAnswerLabel.setVisible(true); // displays the correct answer
        }

        if (correctAnswersCount + wrongAnswersCount == 5) { // game over as there are 5 flags, both the buttons stay
                                                            // disabled

            inputAnswerTextField.setText("Game over"); // display "Game over" on the TextField
        } else { // game countinues

            goToNextFlagButton.setEnabled(true); // enable the go to next flag button
        }
    }

    void goToNextFlagButtonActionPerformed() { // displays image of next flag and refreshes the labels' text

        submitButton.setEnabled(false); // disable the submit button as image of next flag is yet to be displayed

        inputAnswerTextField.setText("Type your answer here"); // displays "Type your answer here" on the TextField
        inputAnswerTextField.setEditable(true); // enables editing of the text field

        answerStatusLabel.setBackground(backgroundColorLavender); // sets the background color to the specified object
                                                                  // of class Color
        answerStatusLabel.setForeground(textColorDarkPurple); // sets the text color to the specified object of class
                                                              // Color
        answerStatusLabel.setText(""); // displays "" on the label
        answerStatusLabel.setVisible(false); // the label is not visible

        correctAnswerLabel.setText(""); // displays "" on the label
        correctAnswerLabel.setVisible(false); // the label is not visible

        goToNextFlagButton.setEnabled(false); // image of next flag will be displayed so disable going the next flag (so
                                              // that user cannot skip a flag, they have to give an answer to go to the
                                              // next flag)

        displayFlag(); // displays a randomly selected image of a flag

        submitButton.setEnabled(true); // enables the submit button so that the user can submit an answer
    }

    public static void main(String args[]) { // creates object of class GuessTheFlagGame, sets size of the frame, adds a
                                             // window listener to handle windowClosing event, displays the frame

        GuessTheFlagGame guessTheFlagGame = new GuessTheFlagGame(); // creates object of the class GuessTheFlagGame
        guessTheFlagGame.setSize(950, 600); // sets size of the frame to the specified width and height
        guessTheFlagGame.addWindowListener(new WindowAdapter() { // adds window listener

            public void windowClosing(WindowEvent event) { // event handling for windowClosing event

                System.exit(0); // closes the frame
            }
        });
        guessTheFlagGame.setVisible(true); // displays the frame
    }
}