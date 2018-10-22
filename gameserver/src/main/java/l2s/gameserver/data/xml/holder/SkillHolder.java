package l2s.gameserver.data.xml.holder;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.ArrayList;
import java.util.List;

import l2s.commons.data.xml.AbstractHolder;
import l2s.gameserver.model.Skill;
import l2s.gameserver.skills.SkillEntry;
import l2s.gameserver.skills.SkillEntryType;
import l2s.gameserver.utils.SkillUtils;

/**
 * @author Bonux
**/
public final class SkillHolder extends AbstractHolder
{
	private static final SkillHolder _instance = new SkillHolder();

	private final TIntObjectMap<SkillEntry> _skills = new TIntObjectHashMap<SkillEntry>();
	private final TIntObjectMap<SkillEntry> _skillsByIndex = new TIntObjectHashMap<SkillEntry>();
	private final TIntObjectMap<List<SkillEntry>> _skillsById = new TIntObjectHashMap<List<SkillEntry>>();

	public static SkillHolder getInstance()
	{
		return _instance;
	}

	public void addSkill(Skill skill)
	{
		SkillEntry skillEntry = new SkillEntry(SkillEntryType.NONE, skill);

		_skills.put(skillEntry.hashCode(), skillEntry);

		List<SkillEntry> skills = _skillsById.get(skillEntry.getId());
		if(skills == null)
		{
			skills = new ArrayList<SkillEntry>();
			_skillsById.put(skillEntry.getId(), skills);
		}
		skills.add(skillEntry);

		_skillsByIndex.put(SkillUtils.generateSkillHashCode(skillEntry.getId(), skills.size()), skillEntry);
	}

	public SkillEntry getSkillEntry(int id, int level)
	{
		return _skills.get(SkillUtils.generateSkillHashCode(id, level));
	}

	public SkillEntry getSkillEntryByIndex(int id, int index)
	{
		return _skillsByIndex.get(SkillUtils.generateSkillHashCode(id, index));
	}

	public Skill getSkill(int id, int level)
	{
		SkillEntry skillEntry = getSkillEntry(id, level);
		if(skillEntry != null)
			return skillEntry.getTemplate();
		return null;
	}

	public List<SkillEntry> getSkills(int id)
	{
		return _skillsById.get(id);
	}

	@Override
	public int size()
	{
		return _skills.size();
	}

	@Override
	public void clear()
	{
		_skills.clear();
		_skillsByIndex.clear();
		_skillsById.clear();
	}
}