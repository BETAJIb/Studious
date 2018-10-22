package l2s.gameserver.skills.effects;

import l2s.gameserver.model.actor.instances.creature.Abnormal;
import l2s.gameserver.stats.Env;
import l2s.gameserver.templates.skill.EffectTemplate;

public final class EffectBuff extends Effect
{
	public EffectBuff(Abnormal abnormal, Env env, EffectTemplate template)
	{
		super(abnormal, env, template);
	}
}