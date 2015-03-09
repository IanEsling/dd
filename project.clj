(defproject dd "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.0.1"]
                 [cheshire "5.4.0"]
                 [org.postgresql/postgresql "9.3-1102-jdbc41"]
                 [yesql "0.4.0"]]
  :main ^:skip-aot dd.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
