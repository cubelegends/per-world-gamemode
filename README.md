# Per World Gamemode

Per World Gamemode is a plugin for [Hytale](https://hytale.com/) servers. It automatically changes gamemode when
switching worlds, based on the gamemode setting of the world you're teleporting to.

## Setup

1. Copy the plugin into the `mods` directory of your server
2. Restart your server

## Usage

1. Create some additional worlds:

```
/world add flat --gen Flat
```

2. Set the correct gamemode for each world:

```
/world settings gamemode set Adventure --world default
/world settings gamemode set Creative --world flat
```

3. Teleport between worlds:

```
/tp world flat
/tp world default
```
