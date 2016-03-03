(
    ;; Temperature
      
    ; latent temperature
    "number as temp"
    (dim :number)
    {:dim :temperature
     :latent true
     :value (:value %1)}

    "<latent temp> temp"
    [(dim :temperature) #"(?i)(graus?)|°"]
    (dissoc %1 :latent)

    "<temp> Celsius"
    [(dim :temperature) #"(?i)(cent(i|í)grados?|c(el[cs]?(ius)?)?\.?)"]
    (-> %1
        (dissoc :latent)
        (merge {:unit "C"}))

    "<temp> Fahrenheit"
    [(dim :temperature) #"(?i)f(ah?reh?n(h?eit)?)?\.?"]
    (-> %1
        (dissoc :latent)
        (merge {:unit "F"}))

    "<latent temp> temp abaixo de zero"
    [(dim :temperature) #"(?i)((graus?)|°)?( abaixo (de)? zero)"]
    (-> %1
        (dissoc :latent)
        (merge {:value (* -1 (-> %1 :value))}))

)