package com.henningstorck.perworldgamemode;

import java.util.UUID;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.event.EventPriority;
import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.entity.UUIDComponent;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class PerWorldGamemodePlugin extends JavaPlugin {
	public PerWorldGamemodePlugin(@NonNullDecl JavaPluginInit init) {
		super(init);
	}

	@Override
	protected void start() {
		initEventHandlers();
	}

	private void initEventHandlers() {
		getEventRegistry().registerGlobal(EventPriority.NORMAL, PlayerReadyEvent.class, this::onPlayerReady);
	}

	private void onPlayerReady(PlayerReadyEvent event) {
		Player player = event.getPlayer();
		World world = player.getWorld();

		if (world == null) {
			return;
		}

		UUIDComponent uuidComponent = event.getPlayerRef().getStore().getComponent(event.getPlayerRef(), UUIDComponent.getComponentType());

		if (uuidComponent == null) {
			return;
		}

		UUID uuid = uuidComponent.getUuid();
		GameMode gameMode = world.getWorldConfig().getGameMode();
		Ref<EntityStore> entityRef = world.getEntityRef(uuid);

		if (entityRef == null) {
			return;
		}

		Player.setGameMode(entityRef, gameMode, world.getEntityStore().getStore());
	}
}
