import java.util.*;
import javax.sound.sampled.*;

class create_audio {

    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        //This is the morse array that we will reference
        String[] morse_letters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] morse_numbers = {"-----",".----","..---","...--","....-",".....","-....","--...","---..","----."};
        //amount of time dots and dashes will make a sound and just a random freq
        int DOT = 200, DASH = DOT * 3, FREQ = 800;

        Scanner scn = new Scanner(System.in);
        System.out.println("Input:");
        String line = scn.nextLine();

        //converting the string input to a char array
        char line_array[] = line.toUpperCase().toCharArray();
        //traversing through the character array
        for (int i = 0; i < line_array.length; i++) {
            int morse_index = -1;
            char morse_array[] ={};           //only convert to morse if it's not a space
            if (line_array[i] != ' ') {
                //finding the index of morse equivalence of the character at i
                if(Character.isDigit(line_array[i])) {
                    morse_index = line_array[i] - '0';
                    morse_array = morse_numbers[morse_index].toCharArray();
                }
                else {
                    morse_index = line_array[i] - 'A';
                    morse_array = morse_letters[morse_index].toCharArray();
                }
                for (int j = 0; j < morse_array.length; j++) {
                    System.out.print(morse_array[j]);
                    //sdl saves the format of the audio
                    try (SourceDataLine sdl = AudioSystem.getSourceDataLine(new AudioFormat(8000F, 8, 1, true, false))) {
                        sdl.open(sdl.getFormat());
                        sdl.start();
                        for (int k = 0; k < (morse_array[j] == '.' ? DOT : DASH) * 8; k++) {
                            //a sine tone is created
                            sdl.write(new byte[]{(byte) (Math.sin(k / (8000F / FREQ) * 2.0 * Math.PI) * 127.0)}, 0, 1);
                        }
                        sdl.drain();
                    }
                }
                Thread.sleep(DOT / 5);
            }
            else
                System.out.println();
        }
    }
}