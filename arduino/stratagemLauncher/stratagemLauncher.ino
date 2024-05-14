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


const int MIN_DELAY_BETWEEN_KEYSTROKE = 85;
const int MAX_DELAY_BETWEEN_KEYSTROKE = 135;

const int MIN_DELAY_PRESS_KEY = 45;
const int MAX_DELAY_PRESS_KEY = 65;

void setup() {

  // initialize leds
  initializeLeds();


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
  if (!testing) {
    Keyboard.press(KEY_LEFT_CTRL);
    delayBetweenKeystrokes();
  }
  for (int i = 0; i < sequence.length(); i++) {
    typeKey(sequence.charAt(i));
  }
  Keyboard.releaseAll();
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

void led(int led, bool state) {
  switch (led) {
    case 1:
      digitalWrite(A0, state);
      break;
    case 2:
      digitalWrite(A1, state);
      break;
    case 3:
      digitalWrite(A2, state);
      break;
    case 4:
      digitalWrite(A3, state);
      break;
  }
}

void initializeLeds() {
  pinMode(A0, OUTPUT);
  pinMode(A1, OUTPUT);
  pinMode(A2, OUTPUT);
  pinMode(A3, OUTPUT);

  for (int i = 1; i < 5; i++) {
    led(i, true);
    delay(250);
    led(i, false);
  }
}
