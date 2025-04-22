package kproc.balls

import processing.core.PApplet
import processing.core.PVector

class Ball(
    position: Position,
    velocity: Velocity,
    val radius: Float,
    val color: Triple<Float, Float, Float>,
) : Thing(position, velocity)

class BouncingBalls() : PApplet() {
    fun createBall(): Ball {
        return Ball(
            Position(0f, 100f),
            Velocity(PVector.fromAngle(-QUARTER_PI) * random(2f, 10f)),
            random(10f, 30f),
            Triple(random(0f, 255f), random(0f, 255f), random(0f, 255f)),
        )
    }

    val balls =
        mutableListOf(
            createBall(),
            createBall(),
            createBall(),
            createBall(),
            createBall(),
            createBall(),
            createBall(),
            createBall(),
        )

    val gravity = Acceleration(0f, 0.5f)

    override fun settings() {
        size(640, 360)
    }

    override fun setup() {
        frameRate(30f)
        ellipseMode(RADIUS)
        background(255)
    }

    override fun draw() {
        background(255)

        balls.forEach {
            it.apply(gravity)
            it.updatePosition(this::bounce)
        }

        // Remove balls out of screen
        balls.removeAll {
            it.position.x > width + it.radius || it.position.x < -it.radius
        }

        // Create new balls to keep 8 balls in screen
        for (i in balls.size..7) {
            balls.add(createBall())
        }

        balls.forEach {
            draw(it)
        }
    }

    fun bounce(g: Thing) =
        if (g is Ball) {
            // Simulate bouncing: for any balls below the bottom ...
            if (g.position.y > height - g.radius) {
                Pair(
                    Position(g.position.x, (height - g.radius).toFloat()),
                    Velocity(g.velocity.x, g.velocity.y * -0.85f),
                )
            } else {
                Pair(g.position, g.velocity)
            }
        } else {
            throw IllegalArgumentException()
        }

    fun draw(b: Ball) {
        stroke(b.color, 255)
        fill(b.color, 180)
        circle(b.position, b.radius)
    }
}

fun main(args: Array<String>) {
    PApplet.main("kproc.balls.BouncingBalls")
}

class Position(x: Float, y: Float) : PVector(x, y) {
    constructor(v: PVector) : this(v.x, v.y)
}

class Velocity(x: Float, y: Float) : PVector(x, y) {
    constructor(v: PVector) : this(v.x, v.y)
}

class Acceleration(x: Float, y: Float) : PVector(x, y) {
    constructor(v: PVector) : this(v.x, v.y)
}

class Force(x: Float, y: Float) : PVector(x, y) {
    constructor(v: PVector) : this(v.x, v.y)
}

open class Thing(val position: Position, val velocity: Velocity, val mass: Float = 1.0f) {
    fun apply(a: Acceleration) {
        velocity.add(a)
    }

    fun apply(f: Force) {
        velocity.add(f / mass)
    }

    fun updatePosition(correction: ((Thing) -> Pair<Position, Velocity>)? = null) {
        position.add(velocity)

        correction?.let {
            val (p, v) = it(this)
            position.set(p)
            velocity.set(v)
        }
    }
}

operator fun PVector.plus(v: PVector): PVector {
    return PVector.add(this, v)
}

operator fun PVector.minus(v: PVector): PVector {
    return PVector.sub(this, v)
}

operator fun PVector.times(n: Float): PVector {
    return PVector.mult(this, n)
}

operator fun PVector.div(n: Float): PVector {
    return PVector.div(this, n)
}

fun PApplet.circle(
    center: PVector,
    radius: Number,
) {
    this.ellipse(center.x, center.y, radius.toFloat(), radius.toFloat())
}

fun PApplet.fill(
    color: Triple<Float, Float, Float>,
    alpha: Number,
) {
    this.fill(color.first, color.second, color.third, alpha.toFloat())
}

fun PApplet.stroke(
    color: Triple<Float, Float, Float>,
    alpha: Number,
) {
    this.stroke(color.first, color.second, color.third, alpha.toFloat())
}
