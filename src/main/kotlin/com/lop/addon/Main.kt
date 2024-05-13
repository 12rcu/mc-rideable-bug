package com.lop.addon

import com.lop.devtools.monstera.addon.addon
import com.lop.devtools.monstera.addon.dev.zipper.zipWorld
import com.lop.devtools.monstera.files.beh.entitiy.components.Components
import com.lop.devtools.monstera.loadConfig
import java.awt.Color

fun main(args: Array<String>) {
    val conf = addon(loadConfig().getOrElse {
        it.printStackTrace()
        return
    }) {
        entity("test_1_19") {
            behaviour {
                unsafeBehEntityVersion = "1.19.0"
                components {
                    rideableComponents()
                }
            }
            resource {
                components {
                    spawnEgg {
                        eggByColor(Color.BLUE, Color.CYAN)
                    }
                }
            }
        }
        entity("test_1_20") {
            behaviour {
                unsafeBehEntityVersion = "1.20.81"
                components {
                    rideableComponents()
                }
            }
            resource {
                components {
                    spawnEgg {
                        eggByColor(Color.GREEN, Color.ORANGE)
                    }
                }
            }
        }
    }

    if (args.contains("zip-world"))
        zipWorld(conf, System.getenv("CI_PROJECT_NAME") ?: "local")
}

fun Components.rideableComponents() {
    physics { }
    movement = 0.2
    inputGroundControlled { }
    rideable {
        seat {
            position(0, 1, 0)
        }
    }
}