(ns core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(def state  (r/atom {:count 20}))

(defn inc! []
  (swap! state update :count inc))

(defn dec! []
  (swap! state update :count dec))

(defn app []
  [:div
   [:h1 "Hello, Reagent!"]
   [:p "Count: " @state]
   [:button {:on-click inc!} "Increment"]
   [:button {:on-click dec!} "Decrement"]
   [:button {:on-click reset!} "Reset"]])

(defn init! []
  (rdom/render [app] (.getElementById js/document "app")))
