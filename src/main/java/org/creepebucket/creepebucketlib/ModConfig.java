package org.creepebucket.creepebucketlib;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {
	public static final ModConfig CONFIG;
	public static final ModConfigSpec CONFIG_SPEC;

	public final ModConfigSpec.BooleanValue disableAnimations;
	public final ModConfigSpec.BooleanValue clientSideInterpolation;
	public final ModConfigSpec.IntValue clientInterpolationWindow;

	static {
		Pair<ModConfig, ModConfigSpec> pair = new ModConfigSpec.Builder()
				.configure(ModConfig::new);
		CONFIG = pair.getLeft();
		CONFIG_SPEC = pair.getRight();
	}

	public ModConfig(ModConfigSpec.Builder builder) {
		builder.push("visual");

		disableAnimations = builder.comment("禁用动画")
				.translation("creepebucketlib.config.disable_animations")
				.define("disable_animations", false);

		builder.pop();

		builder.push("network");

		clientSideInterpolation = builder.comment("启用服务端数据的客户端插值",
						"启用插值后不会改变服务端的数据回传时间, 只是以数据延迟为代价平滑数据值")
				.translation("creepebucketlib.config.client_side_interpolation")
				.define("client_side_interpolation", false);

		clientInterpolationWindow = builder.comment("客户端插值时间窗口",
						"在多长的时间范围内平滑服务端数据(刻)")
				.translation("creepebucketlib.config.client_interpolation_window")
				.defineInRange("client_interpolation_window", 15, 1, Integer.MAX_VALUE);

		builder.pop();
	}
}
