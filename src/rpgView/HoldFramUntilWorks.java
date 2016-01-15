//package rpgView;

//import java.awt.image.BufferedImage;

//public class HoldFramUntilWorks 
//{
//	private BufferedImage frame;
//    private int duration;

//    public Frame(BufferedImage frame, int duration) {
//        this.frame = frame;
//        this.duration = duration;
//    }

//    public BufferedImage getFrame() {
//        return frame;
//    }

//   public void setFrame(BufferedImage frame) {
//        this.frame = frame;
//    }

//    public int getDuration() {
//      return duration;
//   }

//   public void setDuration(int duration) {
//       this.duration = duration;
//   }

//}




//Implemtation

      //Images for each animation
//private BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1}; // Gets the upper left images of my sprite sheet
//private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2};
//private BufferedImage[] standing = {Sprite.getSprite(1, 0)};

      //These are animation states
//private Animation walkLeft = new Animation(walkingLeft, 10);
//private Animation walkRight = new Animation(walkingRight, 10);
//private Animation standing = new Animation(standing, 10);

      //This is the actual animation
//private Animation animation = standing;


     //in update or tick
//animation.update();

    //In your render or draw method you will have:

//g.drawImage(animation.getSprite(), x, y, null);

     //Lets say you have implemented MouseListener

//public void mousePressed(MouseEvent e) {
//    animation = walkLeft;
//    animation.start();
//}

//public void mouseReleased(MouseEvent e) {
//    animation.stop();
//    animation.reset();
//    animation = standing;
//}

