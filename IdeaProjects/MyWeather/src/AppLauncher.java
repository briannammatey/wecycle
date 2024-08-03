import javax.swing.*;
public class AppLauncher {


    public static void main(String[] args) {
        long start = System.nanoTime();
        // some time passes

        SwingUtilities.invokeLater(new Runnable() {
           @Override
            public void run() {
               new Main();
               //System.out.println(WeatherAPI.getCurrentTime());
           }
        });
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(elapsedTime);


    }
}
