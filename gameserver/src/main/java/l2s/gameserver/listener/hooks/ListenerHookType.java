package l2s.gameserver.listener.hooks;

public enum ListenerHookType
{
	NPC_KILL,
	NPC_ASK,
	NPC_FIRST_TALK,
	NPC_SPAWN,
	NPC_DESPAWN,
	PLAYER_FINISH_CAST_SKILL,
	PLAYER_DIE,
	PLAYER_QUIT_GAME,
	PLAYER_ENTER_GAME,
	PLAYER_CREATE,
	PLAYER_TELEPORT,
	GLOBAL_BBS,
	PLAYER_GLOBAL_LEVEL_UP,
	PLAYER_GLOBAL_DIE,
	PLAYER_GLOBAL_FRIEND_ADD,
	PLAYER_GLOBAL_ITEM_ADD,
	PLAYER_GLOBAL_KILL,
	PLAYER_GLOBAL_PvP_COUNT_UP,
	PLAYER_GLOBAL_PK_COUNT_UP,
	PLAYER_GLOBAL_START_CASTLE_SIEGE_IN_CLAN,
	PLAYER_GLOBAL_TAKE_CASTLE,
	PLAYER_GLOBAL_TAKE_DAMAGE;
}