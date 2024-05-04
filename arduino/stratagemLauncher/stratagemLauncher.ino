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
       Keyboard.press(KEY_LEFT_CTRL);
       delay(30); 
       Keyboard.write("a");
       delay(30);
       Keyboard.write("a");
       delay(30);
       Keyboard.write("w");
       delay(30);
       Keyboard.write("d");
       delay(30);
       Keyboard.releaseAll();
     

      startMillis = 0;
    }
  }
}
}