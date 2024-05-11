#include <Keyboard.h>
#include <EEPROM.h>
#include <Keypad.h>

bool testing = true;

const byte ROWS = 4;  //four rows
const byte COLS = 4;  //four columns
char keys[ROWS][COLS] = {
  { '1', '2', '3', 'A' },
  { '4', '5', '6', 'B' },
  { '7', '8', '9', 'C' },
  { '*', '0', '#', 'D' }
};
byte rowPins[ROWS] = { 9, 8, 7, 6 };  //connect to the row pinouts of the keypad
byte colPins[COLS] = { 5, 4, 3, 2 };  //connect to the column pinouts of the keypad
//Create an object of keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS);

int led = 13;        // the PWM pin the LED is attached to
int brightness = 0;  // how bright the LED is
int fadeAmount = 5;  // how many points to fade the LED by

int MIN_DELAY_BETWEEN_KEYSTROKE = 75;
int MAX_DELAY_BETWEEN_KEYSTROKE = 125;

int MIN_DELAY_PRESS_KEY = 40;
int MAX_DELAY_PRESS_KEY = 60;

void setup() {
  // declare pin 9 to be an output for LED:
  pinMode(led, OUTPUT);

  // initialize keyboard control:
  Keyboard.begin();
}


void loop() {
  char key = keypad.getKey();  // Read the key
  // Print if key pressed
  switch (key) {
    case '1':  // reinforce
      typeSequence("wsdaw");
      break;
    case '2':  // resupply
      typeSequence("sswd");
      break;
    case '3':  // hellbomb
      typeSequence("swaswdsw");
      break;
  }
}


void typeSequence(String sequence) {
  analogWrite(led, 255);  // led ON
  if (!testing) {
    Keyboard.press(KEY_LEFT_CTRL);
    delayBetweenKeystrokes();
  }
  for (int i = 0; i < sequence.length(); i++) {
    typeKey(sequence.charAt(i));
  }
  Keyboard.releaseAll();
  analogWrite(led, 0);  // led OFF
}


void typeKey(int key) {
  Keyboard.press(key);
  delayPressKey();
  Keyboard.release(key);
  delayBetweenKeystrokes();
}

void delayPressKey() {
  delay(random(MIN_DELAY_PRESS_KEY, MAX_DELAY_PRESS_KEY));
}

void delayBetweenKeystrokes() {
  delay(random(MIN_DELAY_BETWEEN_KEYSTROKE, MAX_DELAY_BETWEEN_KEYSTROKE));
}

void ledIndication() {
}
