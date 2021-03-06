package mlab.androidgames.mrnom;

import java.util.List;

import mlab.androidgames.framework.Game;
import mlab.androidgames.framework.Graphics;
import mlab.androidgames.framework.Input;
import mlab.androidgames.framework.Input.TouchEvent;
import mlab.androidgames.framework.Screen;

/**
 * Created by Takahiro on 2015/12/27.
 */
public class HelpScreen extends Screen {
    public HelpScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++){
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP){
                if(event.x > 256 && event.y > 416){
                    game.setScreen(new HelpScreen2(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }

    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.background,0,0);
        g.drawPixmap(Assets.help1,64,100);
        g.drawPixmap(Assets.buttons,256,416, 0, 64,64,64);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
