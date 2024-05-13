# Minecraft Rideable/Input Ground Controller Bug

In this repo you find the code to build a minecraft addon that shows that an entity with the component

````json
{
  "minecraft:input_ground_controlled": {}
}
````

can't automatically jump up one block with the current format version.
It was noticed that the bug didn't appear with the format version 1.19.0.

Some other strange behaviour that was found with the newer format version was that the exit position can be within 
blocks which wasn't possible in with the older format version.