import java.*
import semmle.code.java.frameworks.spring.SpringController
import semmle.code.java.frameworks.spring.SpringRequestMapping

from Method m, Annotation a
where
  m.hasAnnotation(a) and
  a.getType().getName().matches("RequestMapping|GetMapping|PostMapping") and
  exists(Variable v |
    v.getAnAnnotation().getType().getName().matches("RequestParam|RequestBody|PathVariable") and
    v.getDeclaringCallable() = m
  )
select m, "Este controlador usa parámetros de entrada sin validación explícita."
