package hernanbosqued.samples.processing

import processing.core.PApplet
import processing.core.PVector

class Fractal() : PApplet() {
    override fun settings() {
        size(440, 220)
    }

    override fun setup() {
        background(255)
        noLoop()
    }

    override fun draw() {
        spiralSquare(
            PVector(0f,0f),
            PVector(200f,0f),
            PVector(200f,200f),
            PVector(0f,200f),
            0f)

        val t1 = PVector(220f, 200f)
        val t2 = PVector(420f, 200f)
        val t3 = PVector(220f + 200f * cos(PI/3), 200f - 200f * sin(PI/3))

        noStroke()
        fill(0)
        triangle(t1, t2, t3)
        sierpinskiTriangle(t1, t2, t3)
    }

    fun spiralSquare(p1: PVector, p2: PVector, p3: PVector, p4: PVector, gray: Float) {
        noStroke()
        fill(gray)
        quad(p1, p2, p3, p4)

        if (dist(p1, p2) > 3) {
            fun next(p: PVector, q: PVector) =
                PVector(p.x + 0.75f * (q.x - p.x), p.y + 0.75f * (q.y - p.y))

            spiralSquare(
                next(p1, p2),
                next(p2, p3),
                next(p3, p4),
                next(p4, p1),
                if (gray == 0f) 255f else 0f)
        }
    }

    fun sierpinskiTriangle(p1: PVector, p2: PVector, p3: PVector) {
        fun mid(p: PVector, q: PVector) =
            PVector(p.x + 0.5f * (q.x - p.x), p.y + 0.5f * (q.y - p.y))

        val p12 = mid(p1,p2)
        val p23 = mid(p2,p3)
        val p31 = mid(p3,p1)

        noStroke()
        fill(255)
        triangle(p12, p23, p31)

        if (dist(p1, p2) > 3) {
            sierpinskiTriangle(p1, p12, p31)
            sierpinskiTriangle(p12, p2, p23)
            sierpinskiTriangle(p31, p23, p3)
        }
    }
}

fun main(args: Array<String>) {
    PApplet.main("hernanbosqued.samples.processing.Fractal")
}

fun PApplet.quad(p1: PVector, p2: PVector, p3: PVector, p4: PVector) {
    this.quad(
        p1.x, p1.y,
        p2.x, p2.y,
        p3.x, p3.y,
        p4.x, p4.y)
}

fun PApplet.triangle(p1: PVector, p2: PVector, p3: PVector) {
    this.triangle(
        p1.x, p1.y,
        p2.x, p2.y,
        p3.x, p3.y)
}

fun PApplet.dist(p: PVector, q: PVector): Float {
    return PApplet.dist(p.x, p.y, q.x, q.y)
}