(ns dolisp.core)

(defmacro dependencies [args & body]
  `(do
     (println "Arguments:" (list ~@args))
     ~@body)
)

;; Maybe this was not useful
(defmacro task-fn [args & body]
  `(fn ~args

    ;; Analyze args here? Or maybe do it outside fn (but still inside a quoted block) and return information as a map

     (println "Arguments:" (list ~@args))
     ;; Function body
     ~@body
  )
)
(defrecord Files-In
  [ ;; TODO list of paths
  ]
  )
(defrecord Files-Out
  [ ;; TODO list of paths
   ]
  )

;; a record that tells if precondition is met.   
;; we don't use deftype because we want immutability
(defrecord Task
  [action ;; function to be run
   executive ;; function to decide whether the action will be executed or not
   ;;file-inputs  ;; input Tasks – how to check input files, though? Can't we pass these as the func arguments instead?
   ;;file-outputs ;; outputs (tasks?)
  ]
)

(defn -main []
  "I'm the entry point for this application."
  (;; function
    (task-fn
      [a b] ;; Change this to something like 'let' so that we can execute the function without an argument
            ;; It's simpler to accept a list and not use arg names, though. 
            ;; But how do we specify output files, then?
      (println (+ a b))
    )
    ;; arguments
    1 2
    )

  (let [a 1 b 2]
    (;; execute this task (aka function)
     (dependencies [a]
                   #(println (+ a b)) ;; anonymous function
                   )
     )
    )
  )
