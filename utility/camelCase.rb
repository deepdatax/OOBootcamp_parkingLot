require "active_support"
require "active_support/core_ext"

puts ARGV[0]

content = ""
File.open(ARGV[0]) do |f| 
	content = f.read
end

content.scan(/(When.*)\(\)/i).to_a.flatten.each{|sub| puts sub}
content.scan(/(When.*)\(\)/i).to_a.flatten.each{|sub| content.gsub!(sub, sub.underscore)}

File.open(ARGV[0], "w") { |file| file.write content }
