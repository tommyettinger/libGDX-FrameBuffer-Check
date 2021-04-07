package com.github.tommyettinger;

import box2dLight.RayHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A black screen right now, but it crashes on 1.9.14. Trying to figure out if some
 * issue may still exist in 1.9.15-SNAPSHOT, but so far it works for me.
 * */
public class FrameBufferLightsCheck extends ApplicationAdapter {
	World world;
	RayHandler rays;
	@Override
	public void create() {
		Box2D.init();
		world = new World(new Vector2(0f, -0.2f), true);
		rays = new RayHandler(world);
		BodyDef bd = new BodyDef();
		bd.active = true;
		bd.position.set(0f,0f);
		world.createBody(bd);
		rays.setAmbientLight(0.5f);
	}

	@Override
	public void render() {
		rays.render();
	}
}