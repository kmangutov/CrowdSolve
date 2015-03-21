class Question < ActiveRecord::Base
	belongs_to :user
	serialize :options
end
