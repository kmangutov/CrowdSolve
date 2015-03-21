Rails.application.routes.draw do
	resources :users

	get "/" => "home#home"
	get "/log-in" => "session#new"
	post "/log-in" => "session#create"
	post "/log-out" => "session#destroy", as: :log_out
end
