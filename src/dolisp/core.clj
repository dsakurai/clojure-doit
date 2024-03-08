(ns dolisp.core)

(defmacro task-fn [args & body]
  `(fn ~args

    ;; Analyze args here? Or maybe do it outside fn (but still inside a quoted block) and return information as a map

     (println "Arguments:" (list ~@args))
     ;; Function body
     ~@body
  )
)

(defn -main []
  "I'm the entry point for this application."
  (;; function
    (task-fn
      [a b]
      (println (+ a b))
    )
    ;; arguments
    1 2
    )
  )
