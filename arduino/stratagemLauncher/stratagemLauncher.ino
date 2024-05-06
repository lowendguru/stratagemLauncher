#include <Keyboard.h>
#include <EEPROM.h>

int led = 13;        // the PWM pin the LED is attached to
int brightness = 0;  // how bright the LED is
int fadeAmount = 5;  // how many points to fade the LED by

int eepromAddress = 0;
int toggle;

unsigned long startMillis;
unsigned long currentMillis;
unsigned long period;

int KEY_W = 87;
int KEY_A = 65;
int KEY_S = 83;
int KEY_D = 68;


int MIN_DELAY_BETWEEN_KEYSTROKE = 100;
int MAX_DELAY_BETWEEN_KEYSTROKE = 150;

int MIN_DELAY_PRESS_KEY = 50;
int MAX_DELAY_PRESS_KEY = 70;

void setup() {
  // declare pin 9 to be an output for LED:
  pinMode(led, OUTPUT);

  // initialize keyboard control:
  Keyboard.begin();

  startMillis = millis();  //initial start time

  toggle = EEPROM.read(eepromAddress);

  if (toggle == 1) {
    // ON
    EEPROM.write(eepromAddress, 0);
  } else {
    // OFF
    analogWrite(led, 0);
    EEPROM.write(eepromAddress, 1);
  }
}

// the loop routine runs over and over again forever:
void loop() {

  if (toggle == 1) {
    // set the brightness of pin 9:
    analogWrite(led, brightness);
    // change the brightness for next time through the loop:
    brightness = brightness + fadeAmount;
    // reverse the direction of the fading at the ends of the fade:
    if (brightness <= 0 || brightness >= 255) {
      fadeAmount = -fadeAmount;
    }
    // wait for 30 milliseconds to see the dimming effect
    delay(30);

    // do once
    if (startMillis != 0) {

      // resupply strat SSWD

      delay(3000);
      Keyboard.press(KEY_LEFT_CTRL);
      delayBetweenKeystrokes();
      typeKey(KEY_S);
      typeKey(KEY_S);
      typeKey(KEY_W);
      typeKey(KEY_D);

      Keyboard.releaseAll();


      startMillis = 0;
    }
  }
}

// TODO: hacer un metodo que reciba un array de KEY_
void typeSequence(){

}


void typeKey(int key) {
  Keyboard.press(key);
  delay(50);
  Keyboard.release(key);
  delayBetweenKeystrokes();
}

void delayPressKey() {
  delay(random(MIN_DELAY_PRESS_KEY, MAX_DELAY_PRESS_KEY));
}

void delayBetweenKeystrokes() {
  delay(random(MIN_DELAY_BETWEEN_KEYSTROKE, MAX_DELAY_BETWEEN_KEYSTROKE));
}
