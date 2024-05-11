#include <Keyboard.h>
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

const int LED_PIN = 13;  // the PWM pin the LED is attached to

const int MIN_DELAY_BETWEEN_KEYSTROKE = 85;
const int MAX_DELAY_BETWEEN_KEYSTROKE = 135;

const int MIN_DELAY_PRESS_KEY = 45;
const int MAX_DELAY_PRESS_KEY = 65;

void setup() {
  // declare pin 9 to be an output for LED:
  pinMode(LED_PIN, OUTPUT);

  // initialize keyboard control:
  Keyboard.begin();
}


void loop() {
  char key = keypad.getKey();  // Read the key
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
  analogWrite(LED_PIN, 255);  // led ON
  if (!testing) {
    Keyboard.press(KEY_LEFT_CTRL);
    delayBetweenKeystrokes();
  }
  for (int i = 0; i < sequence.length(); i++) {
    typeKey(sequence.charAt(i));
  }
  Keyboard.releaseAll();
  analogWrite(LED_PIN, 0);  // led OFF
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
