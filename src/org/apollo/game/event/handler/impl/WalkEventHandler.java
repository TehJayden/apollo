package org.apollo.game.event.handler.impl;

import org.apollo.game.event.handler.EventHandler;
import org.apollo.game.event.handler.EventHandlerContext;
import org.apollo.game.event.impl.WalkEvent;
import org.apollo.game.model.Player;
import org.apollo.game.model.Position;
import org.apollo.game.model.WalkingQueue;

/**
 * A{@link EventHandler} that handles {@link WalkEvent}s.
 * 
 * @author Graham
 */
public final class WalkEventHandler extends EventHandler<WalkEvent> {

	@Override
	public void handle(EventHandlerContext ctx, Player player, WalkEvent event) {
		WalkingQueue queue = player.getWalkingQueue();

		Position[] steps = event.getSteps();
		for (int i = 0; i < steps.length; i++) {
			Position step = steps[i];
			if (i == 0) {
				if (!queue.addFirstStep(step)) {
					return; // ignore packet
				}
			} else {
				queue.addStep(step);
			}
		}

		queue.setRunningQueue(event.isRunning() || player.isRunning());

		if (queue.size() > 0) {
			player.stopAction();
		}
		player.getInterfaceSet().close();
	}

}