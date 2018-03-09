# stratagemLauncher

This small program automates the key sequences required to launch stratagems in the Helldivers game. Using this app will remove all the fun and challenge posed by the stratagem game mechanic. In practice, it is more a hack/cheat than anything else. The only goal of this project is to show a practical example of how any repetitive manual task can and will be replaced by automation.  

This is a Windows PC program intended to work in the PC version of the game.

## How it works

By default, the in-game stratagems are activated by pressing and holding the Ctrl key plus a sequence of directional movement keys (WASD) and finally releasing the Ctrl key. 
This program will map keys in the numpad to a stratagem sequence. The mapping can be chosen by the user via the GUI.
A global key listener library is used to listen to keyboard events while the user is in-game, and then the Java Robot class is used to trigger the corresponding key press sequences.

## Dependencies

This project is written in Java SE 1.8 and it uses Maven to solve library dependencies (which are not that many anyway).
The Java (low-level) System Hook  was used to listen to keyboard input while in-game https://github.com/kristian/system-hook

## Artwork

This non-commercial fan-driven project uses the original in-game artwork to illustrate the stratagem icons and copyright for those images belongs to Arrowhead Studios. 

## License

The code is available under the terms of the MIT License.