Rails.application.routes.draw do
	resources :answers

	resources :questions

	post "/users" => "users#create"
	resources :users


	get "/" => "home#home"
	get "/log-in" => "session#new"
	post "/log-in" => "session#create"
	post "/log-out" => "session#destroy", as: :log_out

	get "/getuid" => "session#uid"
end
