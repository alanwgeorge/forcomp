import scala.annotation.tailrec

singleCharPerms('b', "a") flatMap {v => singleCharPerms('r', v)} flatMap {v => singleCharPerms('f', v)}

def singleCharPerms(c: Char, in: String): Set[String] = {
  0 to in.length map {i => in.splitAt(i) } map {(split) => split._1 + c + split._2} toSet
}

def perms(in: String): Set[String] = {
  in match {
    case x if x.length <= 1 => Set(x)
    case _ => perms(in.tail) flatMap (v => singleCharPerms(in.head, v))
  }
}

perms("barf")
perms("barfoo")